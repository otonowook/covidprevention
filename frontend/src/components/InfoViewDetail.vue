<template>

    <v-card outlined>
        <v-card-title>
            Info # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="RegNmb" v-model="item.regNmb" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ReserveId" v-model="item.reserveId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="ReserveDt" v-model="item.reserveDt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="TestId" v-model="item.testId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="IsolateDt" v-model="item.isolateDt" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'InfoViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/infos/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

