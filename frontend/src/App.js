import GlobalStyle from "./styles/global"
import { toast, ToastContainer } from "react-toastify"
import { styled } from "styled-components";
import Form from "./components/form.js"
import { useState, useEffect } from "react";
import axios from "axios";
import { DataGrid } from "@mui/x-data-grid"
import { format } from 'date-fns';


const Container = styled.div`
 width: 100%;
 max-width: 800px;
 margin-top: 20px;
 display: flex;
 flex-direction: column;
 align-items: center;
 gap: 10px;
`

const Title = styled.h2`
`;
function App() {
  const [filters, setFilters] = useState({});
  const [data, setData] = useState([]);

  const fetchData = async () => {
    const response = await axios.get("http://localhost:8080/transferencia", { params: filters })
    const retorno = response.data
    if (retorno.length === 0) {
      alert('Nenhum resultado encontrado na pesquisa.');
    } else {
      setData(retorno)

    }
  };

  const formatDate = (dateString) => {
    const date = new Date(dateString);
    return format(date, 'dd/MM/yyyy');
  };

  const formatCurrency = (value) => {
    return Number(value).toLocaleString("pt-BR", { style: "currency", currency: "BRL" });
  };

  const formattedData = data.map((item) => ({
    ...item,
    dataTransferencia: formatDate(item.dataTransferencia),
    valor: formatCurrency(item.valor),
  }));

  const columns = [
    { field: "dataTransferencia", headerName: "Dados", width: 200 },
    { field: "valor", headerName: "Valência", width: 180 },
    { field: "tipo", headerName: "Tipo", width: 130 },
    { field: "nomeOperadorTransacao", headerName: "Nome do operador", width: 220 }
  ];

  const handleFiltersSubmit = (filters) => {
    setFilters(filters);
  };

  const notificacao = () => {
    alert('Nenhum resultado satisfaz a pesquisa.')
  }

  useEffect(() => {
    if (Object.keys(filters).length > 0) {
      fetchData();
    }
  }, [filters]);
  return (
    <>
      <Container>
        <Title>CONSULTAR</Title>
        <Form onFiltersSubmit={handleFiltersSubmit}></Form>
        {data.length > 0 ? <DataGrid
          style={{ width: '100%', backgroundColor: 'white' }}
          rows={formattedData}
          columns={columns}
          initialState={{
            pagination: {
              paginationModel: { page: 0, pageSize: 5 },
            },
          }}
          pageSizeOptions={[5, 10]}
        /> : ''}
      </Container>
      <ToastContainer></ToastContainer>
      <GlobalStyle></GlobalStyle>
    </>
  );
}

export default App;
