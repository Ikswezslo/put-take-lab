<script setup>
import { ref } from 'vue';
import { store } from '../store';
import { useRouter } from 'vue-router';

defineProps({heading: String})

const firstname = ref("");
const lastname = ref("");
const router = useRouter();

function onSubmit() {
    store.addPerson(firstname.value, lastname.value)
    firstname.value = "";
    lastname.value = "";
    router.push({ name: 'list'});
}
</script>
<template>
    <h1>{{ heading }}</h1>
    <form @submit.prevent="onSubmit">
        <input v-model="firstname" placeholder="First Name" />
        <input v-model="lastname" placeholder="Last Name" />
        <button type="submit">Add person</button>
    </form>
</template>
