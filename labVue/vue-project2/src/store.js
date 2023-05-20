import { reactive } from 'vue'
export const store = reactive({
    personList: [{ firstname: "Jan", lastname: "Kowalski" }],

    addPerson(firstname, lastname) {
        this.personList.push({ firstname, lastname });
    }
})