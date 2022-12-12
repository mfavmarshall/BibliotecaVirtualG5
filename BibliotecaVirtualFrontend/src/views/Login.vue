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
            <button class="btn btn-secondary">Registrarse</button>
        </div>
    </div>
</template>

<script>
export default {
    props: ['token'],

    data() {
        return {
            bienvenida: "Por favor inicia sesion o crea tu cuenta",
            usuario: "",
            contrasena: ""
        };
    },
    methods: {
        iniciarSesion() {
            let login = {
                nombreUsuario: this.usuario,
                contrasenaUsuario: this.contrasena,
            };

            if (this.usuario == "" || this.contrasena == "") {
                alert("Los campos usuario y contraseña con obligatorios");
            }

            const opciones = {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(login),
            };
            const url = "http://150.136.97.54:8080/bibliotecavirtual/api/token";

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
                    this.$emit('token',data.token)
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
