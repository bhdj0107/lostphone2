<template>

    <v-data-table
        :headers="headers"
        :items="memberInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MemberInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "contact", value: "contact" },
                { text: "name", value: "name" },
            ],
            memberInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/memberInfos'))

            temp.data._embedded.memberInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.memberInfo = temp.data._embedded.memberInfos;
        },
        methods: {
        }
    }
</script>

