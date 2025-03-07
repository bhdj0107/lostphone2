<template>

    <v-data-table
        :headers="headers"
        :items="lostInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'LostInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "deviceId", value: "deviceId" },
                { text: "memberId", value: "memberId" },
                { text: "status", value: "status" },
                { text: "contact", value: "contact" },
                { text: "information", value: "information" },
            ],
            lostInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/lostInfos'))

            temp.data._embedded.lostInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.lostInfo = temp.data._embedded.lostInfos;
        },
        methods: {
        }
    }
</script>

