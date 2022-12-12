<template>
    <h6>{{ editar }}</h6>
    <form>
        <div class="mb-3">
            <label for="usuario" class="form-label">Usuario</label>
            <input v-model="usuario" type="text" class="form-control" id="usuario" placeholder="Usuario" />
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Contraseña</label>
            <input v-model="contrasena" type="password" class="form-control" id="password" placeholder="Contraseña" />
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Correo electrónico</label>
            <input v-model="correo" type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Correo electrónico" />
        </div>
    </form>
    <div>
        <button @click="crearUsuario" class="btn btn-primary">Crear cuenta</button>
        <RouterLink class="btn btn-secondary" to="/home">Atrás</RouterLink>
    </div>
</template>

<script>
export default {
    data() {
        return {
            editar: "Ingresa los datos solicitados",
            usuario: "",
            contrasena:"",
            correo: ""
        }
    },
    methods: {
        crearUsuario() {
           let cuenta = {
            nombreUsuario: this.usuario,
            contrasenaUsuario: this.contrasena,
            correoUsuario: this.correo
           };

           if (this.usuario == "" || this.contrasena == "" || this.correo == "") {
                alert("Los campos usuario y contraseña con obligatorios");
                return
            }

            const opciones = {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(cuenta),
            };
            const url = "http://150.136.97.54:8080/bibliotecavirtual/api/usuarios";

            fetch(url, opciones)
                .then((response) => {
                    if (response.status == 201) {
                        return response.json();
                    } else {
                        const error = new Error(response.statusText);
                        error.jason = response.json();
                        console.log(error.message);
                        throw error;
                    }
                })
                .then((data) => {
                    alert("Cuenta creada")
                    this.$router.push({
                        name:'login'
                    })
                });
        }
    }
}
</script>

<style>

</style>
