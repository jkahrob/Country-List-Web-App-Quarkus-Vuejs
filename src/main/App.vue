<template>
  <div id="app">
    <h1>Countries</h1>
    <p>Search:</p>
      <input v-model="search" @input="filterCountries" />
    <ul class="country-list">
      <li v-for="country in sortedCountries" :key="country.name.common" @click="toggleDetails(country)">
        <div class="country-item">
        {{ country.name.common }}
          <transition name="fade">
            <div v-if="country.showDetails" class="additional-details">
              <h5>Official Name: <p>{{ country.name.official }}</p></h5>
              <h5>Capital: <p>{{ getCapitalName(country.capital) }}</p></h5>
              <h5>Flag: <h1>{{ country.flag }}</h1></h5>
              <h5>Region: <p>{{ country.region }}</p></h5>
              <h5>Population: <p>{{ country.population }}</p></h5>
              <h5>Area: <p>{{ country.area }} square kilometers</p></h5>
            </div>
          </transition>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import json from './sampleResponse/response.json'
export default {
  data() {
    return {
      countries: [],
      selectedCountry: null,
      search: '',
      currency: null,
      jsonData: json,
    };
  },
  computed: {
    filteredCountries() {
      const query = this.search.toLowerCase();
      return this.countries.filter(country => country.name.common.toLowerCase().includes(query));
    },
    sortedCountries() {
      return this.filteredCountries.slice().sort((a, b) => a.name.common.localeCompare(b.name.common));
    },
  },
  mounted() {
    this.fetchCountries();
  },
  methods: {
    async fetchCountries() {
      try {
        const response = json;
        const data = await response;
        this.countries = data.map(country => ({ ...country, showDetails: false }));
      } catch (error) {
        console.error('Error fetching countries:', error);
      }
    },
    toggleDetails(country) {
      country.showDetails = !country.showDetails;
    },
    filterCountries() {
    },
    getCapitalName(capital) {
      if (capital) {
        return capital[0];
      } else {
        return '';
      }
    },
  },
};
</script>

<style>
#app {
  text-align: center;
  color: #2c3e50;
  margin-top: 30px;
}

body {
  background-image: url(assets/Image35.jpg);
  background-color: #000000;
  padding: 0;
  margin: 0;
}

.country-list {
  color: white;
  list-style: none;
  padding: 12px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.additional-details {
  text-align: left;
  opacity: 1;
  transition: opacity 0.5s ease-in-out;
}

.fade-enter-active, .fade-leave-active {
  opacity: 0;
  transition: opacity 0.2s;
}

.fade-enter, .fade-leave-to {
  opacity: 0;
  transition: opacity 0.5s;
}

h1 {
  color: white;
  font-size: 2em;
  font-family: Arial,serif;
}

h5 {
  color: white;
  font-size: 0.8em;
  font-family: Arial,serif;
}

p {
  color: white;
  font-size: 1.4em;
  font-family: Arial,serif;
}

ul {
  color: white;
  list-style: none;
  padding: 0;
}

li {
  color: white;
  margin: 10px 0;
  font-size: 1.2em;
  font-family: Arial,serif;
}
</style>