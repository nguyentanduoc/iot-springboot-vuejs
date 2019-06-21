<template>
	<div :id='$options.name'>
		<v-card>
			<v-toolbar card dense color="transparent">
				<v-toolbar-title><h4>List Sensor of User</h4></v-toolbar-title>
				<v-spacer></v-spacer>
				<v-btn icon>
					<v-icon>refresh</v-icon>
				</v-btn>
			</v-toolbar>
			<v-divider></v-divider>
			<v-card-text>
				<v-data-table
						v-if="!sensors.empty"
						:headers="headers"
						:items="sensors.content">
					<template v-slot:items="props">
						<td class="text-xs-left">
							{{ props.item.id.substring(0,8) }}...
							<v-icon v-clipboard="props.item.id" @click="clipboard(props.item.id)">file_copy</v-icon>
						</td>
						<td class="text-xs-left">{{ props.item.userModel.name }}</td>
						<td class="text-xs-left">{{ props.item.typeSensor.name }}</td>
						<td class="text-xs-left">
							<v-chip
									:color="props.item.enabled ? 'green' : 'red'"
									text-color="white"
									label small>
								{{props.item.enabled ? 'enabled' : 'disabled'}}
							</v-chip>
						</td>
						<td class="text-xs-left">
							{{ props.item.createdAt | moment('timezone', 'Asia/Ho_Chi_Minh', 'YYYY-MM-DD HH:mm')}}
						</td>
						<td class="text-xs-left">
							{{ props.item.updatedAt| moment('timezone', 'Asia/Ho_Chi_Minh', 'YYYY-MM-DD HH:mm')}}
						</td>
						<td class="justify-center px-0">
							<v-btn depressed icon dark color="primary" small @click="editItem(props.item)">
								<v-icon>edit</v-icon>
							</v-btn>
							<v-btn depressed icon dark color="pink" small @click="deleteItem(props.item)">
								<v-icon>delete</v-icon>
							</v-btn>
						</td>
					</template>
				</v-data-table>
			</v-card-text>
		</v-card>
	</div>
</template>

<script>
  import {mapGetters} from 'vuex';
  import moment from 'moment';

  export default {
    name: "ListSensorOfUser",
    data() {
      return {
        headers: [
          {text: 'UUID', align: 'left', value: 'id'},
          {text: 'User Name', align: 'left', value: 'userModel'},
          {text: 'Type of Sensor', align: 'left', value: 'typeSensor'},
          {text: 'Enabled', align: 'left', value: 'enabled'},
          {text: 'Created at', align: 'left', value: 'enabled'},
          {text: 'Updated at', align: 'left', value: 'enabled'},
          {text: 'Actions', align: 'left', value: 'name', sortable: false,}
        ]
      }
    },
    computed: {
      ...mapGetters(['sensors'])
    },
    methods: {
      clipboard(value) {
        console.log(value)
      },
      moment
    }
  }
</script>

<style scoped>

</style>