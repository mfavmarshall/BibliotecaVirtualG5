<template>
    <div class="row">
        <h6>{{bienvenida}}</h6>
        <form>
            <div class="mb-3">
                <label for="usuario" class="form-label">Ingresa tu usuario</label>
                <input type="text" class="form-control" id="usuario" placeholder="Usuario">
            </div>
            <div class="mb-3">
                <label for="epassword" class="form-label">Ingresa tu contraseña</label>
                <input type="password" class="form-control" id="password" placeholder="Contraseña">
            </div>
            <button type="submit" class="btn btn-primary">Iniciar sesión</button>
            <button class="btn btn-secondary">Registrarse</button>
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            bienvenida: 'Por favor inicia sesion o crea tu cuenta'
        };
    } 
}
</script>

<style>

</style>