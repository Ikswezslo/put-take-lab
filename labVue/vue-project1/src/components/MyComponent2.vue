<script setup>
import { ref, computed } from 'vue';

const firstname = ref("");
const lastname = ref("");
const personList = ref([{ firstname: "Jan", lastname: "Kowalski" }]);

function addPerson(firstname, lastname) {
    personList.value.push({ firstname, lastname });
    this.firstname = "";
    this.lastname = "";
}

const personCount = computed(() => { return personList.value.length; });
</script>
<template>
    <form @submit.prevent="addPerson(firstname, lastname)">
        <input v-model="firstname" placeholder="First Name" />
        <input v-model="lastname" placeholder="Last Name" />
        <button type="submit">Add person</button>
    </form>

    <li v-for="person in personList">
        {{ `${person.firstname} ${person.lastname}` }}
    </li>
    <span>Person count: {{ personCount }}</span>
</template>
