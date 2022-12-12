<template>
        <div>
            <Header />
            <div class="row">
                <RouterView />
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
        return {}
    },
    components: {Header, Footer},
}
</script>

<style>
.row{
    padding-left: 50px;
    padding-top: 15px
}

</style>