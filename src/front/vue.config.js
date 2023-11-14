const { defineConfig } = require('@vue/cli-service');
const path = require('path');

module.exports = defineConfig({
	outputDir: path.resolve(__dirname, '../../src/main/resources/static'),
    transpileDependencies: true,
     configureWebpack: {
        resolve: {
	      alias: {
	        // Adiciona aliases para facilitar as importações
	        'components': '@/components',
	        'views': '@/views',
	        // Você pode adicionar mais aliases conforme necessário
	      }
    },
    plugins: [
      // Aqui, você pode adicionar qualquer plugin do Webpack que você possa precisar
      // Exemplo: new MyWebpackPlugin()
    ]
  },
  devServer: {
    port: 3000,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        ws: true,
      },
    },
  }
});

