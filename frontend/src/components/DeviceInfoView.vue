<template>

    <v-data-table
        :headers="headers"
        :items="deviceInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DeviceInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "name", value: "name" },
                { text: "status", value: "status" },
                { text: "information", value: "information" },
                { text: "location", value: "location" },
            ],
            deviceInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/deviceInfos'))

            temp.data._embedded.deviceInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.deviceInfo = temp.data._embedded.deviceInfos;
        },
        methods: {
        }
    }
</script>

