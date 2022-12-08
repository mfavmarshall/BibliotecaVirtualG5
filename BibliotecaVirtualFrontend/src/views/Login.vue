<template>
    <div class="row">
        <h6>{{bienvenida}}</h6>
        <form>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Ingresa tu usuario</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Usuario">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Ingresa tu contraseña</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Contraseña">
            </div>
            <button type="submit" class="btn btn-primary">Iniciar sesión</button>
        </form>
    </div>
</template>

<script>

export default {
    data() {
        return {
            bienvenida: 'Por favor inicia sesion'
        };
    } 
}
</script>

<style>

</style>