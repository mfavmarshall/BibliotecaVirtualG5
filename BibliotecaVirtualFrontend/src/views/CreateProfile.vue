<template>
    <h6>{{ editar }}</h6>
    <form>
        <div class="mb-3">
            <label for="usuario" class="form-label">Usuario</label>
            <input type="text" class="form-control" id="usuario" placeholder="Usuario" />
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Contraseña</label>
            <input type="password" class="form-control" id="password" placeholder="Contraseña" />
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Correo electrónico</label>
            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Correo electrónico" />
        </div>
        <button type="submit" class="btn btn-primary">Crear cuenta</button>
        <button class="btn btn-secondary">Atrás</button>
    </form>
</template>

<script>
export default {
    data() {
        return {
            editar: "Ingresa los datos solicitados",
        }
    },
    methods: {
        crearUsuario() {
            
        }
    }
}
</script>

<style>

</style>
