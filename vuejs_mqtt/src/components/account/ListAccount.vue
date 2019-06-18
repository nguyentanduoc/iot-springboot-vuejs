<template>
	<v-card>
		<v-card-text>
			<v-data-table
					class="elevation-1"
					:headers="headers"
					:items="accounts.content"
					:pagination.sync="pagination"
					:rows-per-page-items="pagination.rowsPerPageItems"
					:total-items="pagination.totalItems"
					hide-actions
			>
				<template v-slot:items="props">
					<td class="text-xs-left">{{ props.item.username }}</td>
					<td class="text-xs-left">{{ props.item.email }}</td>
				</template>
			</v-data-table>
			<div class="text-xs-center pt-3">
				<v-pagination
						:value="accounts.number + 1"
						:length="accounts.totalPages"
						:total-visible="7"
						circle
						prev-icon="keyboard_arrow_left"
						next-icon="keyboard_arrow_right"
				></v-pagination>
			</div>
		</v-card-text>
	</v-card>
</template>

<script>
  import {mapGetters} from 'vuex'

  export default {
    name: "ListAccount",
    data() {
      return {
        headers: [
          {
            text: 'Full Name',
            align: 'left',
            value: 'name'
          },
          {text: 'Email', value: 'email'},
        ],
        pagination: {
          descending: true,
          page: 1,
          rowsPerPage: 5,
          sortBy: 'fat',
          totalItems: 0,
          rowsPerPageItems: [5, 10, 15, 20],
        },
      }
    },
    beforeCreate() {
      this.$store.dispatch("getAccount");
    },
    computed: {
      ...mapGetters(['accounts'])
    },
    created() {
      // if (this.accounts) {
      //   this.pagination.page = this.accounts.number + 1;
      //   this.pagination.rowsPerPage = this.accounts.size;
      //   this.pagination.totalItems = this.accounts.totalElements;
      // }
    }
  }
</script>

<style scoped>

</style>