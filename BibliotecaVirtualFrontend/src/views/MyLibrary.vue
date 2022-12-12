<template>
  <div>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Id</th>
          <th scope="col">Título</th>
          <th scope="col">Autor</th>
          <th scope="col">Editorial</th>
          <th scope="col">Fecha de publicación</th>
          <th scope="col">Tipo</th>
          <th scope="col">Id de usuario</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(book, index) in books">
          <th scope="row">{{ (index + 1) }}</th>
          <td>{{ book.titulo }}</td>
          <td>{{ book.autor }}</td>
          <td>{{ book.editorial }}</td>
          <td>{{ book.fechaPublicacion }}</td>
          <td>{{ book.tipo }}</td>
          <td>{{ book.idUsuario }}</td>
        </tr>
      </tbody>
    </table>
  </div>
  <div class="btn-toolbar">
    <button @click="consultarLibros" class="btn btn-primary">Consultar libros</button>
    <button @click="atras" class="btn btn-secondary">Atrás</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      books: [],
      vtoken: ''
    };
  },
  props: ['token'],
  mounted() {
    // console.log(this.token)
    this.updateToken()
  },
  methods: {
    consultarLibros() {
      const opciones = {
        method: 'GET',
        headers: {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + this.vtoken,
        },
      };
      const url = "http://150.136.97.54:8080/bibliotecavirtual/api/libros";

      fetch(url, opciones)
        .then((response) => {
          if (response.status == 200) {
            return response.json();
          } else {
            const error = new Error(response.statusText);
            error.jason = response.json();
            console.log(error.message);
            throw error;
          }
        })
        .then((data) => {
          console.log(data)
          this.books = data
        })
    },
    updateToken() {
      this.vtoken = this.token
    },
    atras() {
      this.$router.push({
        name: 'home'
      })
    }
  },
};
</script>

<style>

</style>
