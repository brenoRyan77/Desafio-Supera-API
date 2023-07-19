import React, { useState } from "react";
import { useRef } from "react";
import styled from "styled-components"

const FormContainer = styled.form`
  display: flex;
  align-items: flex-end;
  gap: 10px;
  flex-wrap: wrap;
  background-color: #fff;
  padding: 20px;
  box-shadow: 0px 0px 5px #ccc;
  border-radius: 5px;
`;

const InputArea = styled.div`
  display: flex;
  flex-direction: column;
`;

const Input = styled.input`
  width: 169px;
  padding: 0 10px;
  border: 1px solid #bbb;
  border-radius: 5px;
  height: 40px;
`;

const Label = styled.label``;

const Button = styled.button`
  padding: 10px;
  cursor: pointer;
  border-radius: 5px;
  border: none;
  background-color: #2c73d2;
  color: white;
  height: 42px;
`;


const Form = ({ onFiltersSubmit }) => {
  const ref = useRef();

  const [dataInicial, setDataInicial] = useState(null)
  const [dataFinal, setDataFinal] = useState(null)
  const [nomeOperador, setNomeOperador] = useState(null)

  const handleFormSubmit = (e) => {
    e.preventDefault();

    const data = {
      dataInicial: dataInicial,
      dataFinal: dataFinal,
      nomeOperador: nomeOperador === '' ? null : nomeOperador,
    };

    onFiltersSubmit(data);
  };

  return (
    <FormContainer ref={ref} onSubmit={handleFormSubmit}>
      <InputArea>
        <Label>Data de início</Label>
        <Input onChange={(event) => {
          setDataInicial(event.target.value)
        }} name="dtInicio" type="date"></Input>
      </InputArea>
      <InputArea>
        <Label>Data Final</Label>
        <Input onChange={(event) => {
          setDataFinal(event.target.value)
        }} name="dtFim" type="date"></Input>
      </InputArea>
      <InputArea>
        <Label>Nome do operador </Label>
        <Input onChange={(event) => {
          setNomeOperador(event.target.value)
        }} name="operador"></Input>
      </InputArea>
      <Button type="submit">Pesquisar</Button>
    </FormContainer>
  );
};

export default Form;