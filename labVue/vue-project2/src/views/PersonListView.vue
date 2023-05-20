<script setup>
import { computed } from 'vue';
import { store } from '../store';

defineProps({heading: String})

const personCount = computed(() => { return store.personList.length; });
</script>
<template>
    <h1>{{ heading }}</h1>
    <li v-for="person in store.personList">
        {{ `${person.firstname} ${person.lastname}` }}
    </li>
    <span>Person count: {{ personCount }}</span>
</template>
