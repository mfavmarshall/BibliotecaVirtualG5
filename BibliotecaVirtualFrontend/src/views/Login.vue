<template>
    <div class="row">
        <h6>{{ bienvenida }}</h6>
        <form>
            <div class="mb-3">
                <label for="usuario" class="form-label">Ingresa tu usuario</label>
                <input v-model="usuario" type="text" class="form-control" id="usuario" placeholder="Usuario" />
            </div>
            <div class="mb-3">
                <label for="epassword" class="form-label">Ingresa tu contraseña</label>
                <input v-model="contrasena" type="password" class="form-control" id="password"
                    placeholder="Contraseña" />
            </div>
        </form>
        <div class="mb-3">
            <button @click="iniciarSesion" class="btn btn-primary">
                Iniciar sesión
            </button>
            <RouterLink class="btn btn-secondary" to="/createprofile">Registrarse</RouterLink>
        </div>
    </div>
</template>

<script>
export default {

    data() {
        return {
            bienvenida: "Por favor inicia sesion o crea tu cuenta",
            usuario: "",
            contrasena: "",
        };
    },
    methods: {
        iniciarSesion() {

            if (this.vusuario == "" || this.vcontrasena == "") {
                alert("Los campos usuario y contraseña con obligatorios");
                return
            }

            const opciones = {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    nombreUsuario: this.usuario,
                    contrasenaUsuario: this.contrasena,
                }),
            };
            const url = "http://150.136.97.54:8080/bibliotecavirtual/api/token";

            fetch(url, opciones)
                .then((response) => {
                    if (response.status == 200) {
                        return response.json();
                    } else {
                        const error = new Error(response.statusText);
                        error.json = response.json();
                        console.log(error.message);
                        throw error;
                    }
                })
                .then((data) => {
                    // console.log(data)
                    sessionStorage.setItem("lusuario", this.usuario)
                    sessionStorage.setItem("lcontrasena", this.contrasena)
                    this.$router.push({
                        name:'home'
                    })
                });
        },
    },
};
</script>

<style>

</style>
