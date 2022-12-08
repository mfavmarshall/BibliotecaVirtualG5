<template>
    <div>
        <h4>{{mensaje}}</h4>
    </div>
        <div class="row">
            <ul class="nav">
                <li class="nav-item">
                    <RouterLink class="nav-link" to="/mylibrary">Mi biblioteca</RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink class="nav-link" to="/editprofile">Editar perfil</RouterLink>
                </li>
            </ul>
        </div>
        <div class="container" style="min-height: 500px">
        </div>
</template>

<script>
import {RouterLink} from 'vue-router';

export default {
    data(){
        return{
            mensaje: 'Bienvenido a tu biblioteca virtual',
        }
    }
}

</script>

<style>


</style>