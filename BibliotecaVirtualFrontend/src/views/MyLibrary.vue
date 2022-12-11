<template>
  <div>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Id</th>
          <th scope="col">Título</th>
          <th scope="col">Autor</th>
          <th scope="col">Editorial</th>
          <th scope="col">Fecha publicación</th>
          <th scope="col">Tipo</th>
          <th scope="col">Id de usuario</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>@fat</td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>Larry the Bird</td>
          <td>@twitter</td>
        </tr>
      </tbody>
    </table>
  </div>
  <div class="btn-toolbar">
    <button @click="consultarLibros" class="btn btn-primary">Consultar libros</button>
    <button class="btn btn-secondary">Atrás</button>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {
    consultarLibros() {
      const opciones = {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          Authorization: "Basic klasdgdfdfwkqaleifudgwed",
        },
      };
      const url = "http://localhost:8080/api/libros";

      fetch(url, opciones).then(async (response) => {
        if (response.ok) {
          const infoLibros = await response.json();
          console.log(infoLibros);
        } else {
          const error = new Error(response.statusText);
          error.jason = response.json();
          console.log(error.message);
          throw error;
        }
      });
    },
  },
};
</script>

<style>
  
</style>
