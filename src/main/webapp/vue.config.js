const { defineConfig } = require('@vue/cli-service')
module.exports = {
  publicPath: process.env.NODE_ENV === 'production' ? '/Country-List-Web-App-Quarkus-Vuejs/' : '/',
};
