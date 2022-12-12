<template>
    <h6>{{ editar }}</h6>
    <form>
        <div class="mb-3">
            <input v-model="usuario" type="text" class="form-control" id="usuario" placeholder="Usuario">
        </div>
        <div class="mb-3">
            <input v-model="contrasena" type="password" class="form-control" id="password" placeholder="Contraseña">
        </div>
        <div class="mb-3">
            <input v-model="correo" type="email" class="form-control" id="email" aria-describedby="emailHelp"
                placeholder="Correo electrónico" />
        </div>
    </form>
    <div>
        <button @click="actualizarUsuario" class="btn btn-primary">Actualizar</button>
        <button @click="eliminarUsuario" class="btn btn-danger">Eliminar cuenta</button>
        <RouterLink class="btn btn-secondary" to="/home">Atrás</RouterLink>
    </div>
</template>

<script>
export default {
    data() {
        return {
            editar: 'Modifica el dato de tu interés',
            usuario: "",
            contrasena: "",
            correo: "",
            token: "",
            lusuario: "",
        };
    },
    mounted () {
        this.llenarInfo()
    },
    methods: {
        async actualizarUsuario() {
            let lusuario, lcontrasena;
            lusuario = sessionStorage.getItem("lusuario")
            lcontrasena = sessionStorage.getItem("lcontrasena")

            let opcionesToken = {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    nombreUsuario: lusuario,
                    contrasenaUsuario: lcontrasena
                }),
            };
            const urlToken = "http://150.136.97.54:8080/bibliotecavirtual/api/token";

            let responseToken = await fetch(urlToken, opcionesToken);
            let dataToken = await responseToken.json();

            let token = dataToken.token;

            const opcionesUser = {
                method: 'PUT',
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + token,
                },
                body: JSON.stringify({
                    nombreUsuario: this.usuario,
                    contrasenaUsuario: this.contrasena,
                    correoUsuario: this.correo
                }),
            };
            const urlUser = "http://150.136.97.54:8080/bibliotecavirtual/api/usuarios/" + lusuario;

            let response = await fetch(urlUser, opcionesUser)
            let data = await response.json()
            console.log(data)

        },
        async llenarInfo() {
            let lusuario, lcontrasena;
            lusuario = sessionStorage.getItem("lusuario")
            lcontrasena = sessionStorage.getItem("lcontrasena")

            let opcionesToken = {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    nombreUsuario: lusuario,
                    contrasenaUsuario: lcontrasena
                }),
            };
            const urlToken = "http://150.136.97.54:8080/bibliotecavirtual/api/token";

            let responseToken = await fetch(urlToken, opcionesToken);
            let dataToken = await responseToken.json();

            let token = dataToken.token;

            const opcionesUser = {
                method: 'GET',
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + token,
                },
            };
            const urlUser = "http://150.136.97.54:8080/bibliotecavirtual/api/usuarios/" + lusuario;

            let response = await fetch(urlUser, opcionesUser)
            let data = await response.json()
            this.usuario = data.nombreUsuario
            this.contrasena = data.contrasenaUsuario
            this.correo = data.correoUsuario
            
        },
        async eliminarUsuario() {
            let lusuario, lcontrasena;
            lusuario = sessionStorage.getItem("lusuario")
            lcontrasena = sessionStorage.getItem("lcontrasena")

            let opcionesToken = {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    nombreUsuario: lusuario,
                    contrasenaUsuario: lcontrasena
                }),
            };
            const urlToken = "http://150.136.97.54:8080/bibliotecavirtual/api/token";

            let responseToken = await fetch(urlToken, opcionesToken);
            let dataToken = await responseToken.json();

            let token = dataToken.token;

            const opcionesUser = {
                method: 'DELETE',
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + token,
                },
            };
            const urlUser = "http://150.136.97.54:8080/bibliotecavirtual/api/usuarios/" + lusuario;

            let response = await fetch(urlUser, opcionesUser)
            // let data = await response.json()
            // console.log(data)
            alert("El usuario ha sido eliminado")
            this.$router.push({name: 'login'})
        }
    },

}
</script>

<style>

</style>