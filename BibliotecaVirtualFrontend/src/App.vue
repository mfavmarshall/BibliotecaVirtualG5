<template>
        <div>
            <Header />
            <div class="row">
            <RouterView :token="token" @token="updateToken"/>
            </div>
            <Footer />
        </div>
</template>

<script>
import {RouterView} from 'vue-router';
import Header from './components/Header.vue';
import Footer from './components/Footer.vue';

export default {
    data() {
        return {
            token: ''
        }
    },
    components: {Header, Footer},
    methods: {
        updateToken(token){
            this.token=token
        }
    }
}
</script>

<style>
.row{
    padding-left: 50px;
    padding-top: 15px
}

</style>