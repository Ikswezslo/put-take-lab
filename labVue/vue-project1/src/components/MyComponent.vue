<script>
export default {
    data() {
        return {
            firstname: "",
            lastname: "",
            personList: [{ firstname: "Jan", lastname: "Kowalski" }]
        }
    },
    methods: {
        addPerson(firstname, lastname) {
            this.personList.push({ firstname, lastname });
            this.firstname = "";
            this.lastname = "";
        }
    },
    computed: {
        personCount() {
            return this.personList.length;
        }
    }
}
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
    <span>Person count: {{personCount}}</span>
</template>
