<template>
    <h6>{{editar}}</h6>
    <form>
            <div class="mb-3">
                <input type="text" class="form-control" id="usuario" placeholder="Usuario">
            </div>
            <div class="mb-3">
                <input type="password" class="form-control" id="password" placeholder="Contraseña">
            </div>
            <div class="mb-3">
                <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Correo electrónico" />
            </div>
            <button type="submit" class="btn btn-primary">Actualizar</button>
            <button class="btn btn-danger">Eliminar cuenta</button>
        </form>
</template>

<script>
    export default {
    data() {
        return {
            editar: 'Modifica el dato de tu interés'
        };
    } 
}
</script>

<style>

</style>