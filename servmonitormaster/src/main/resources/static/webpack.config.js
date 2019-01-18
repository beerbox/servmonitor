const path = require('path');

module.exports = {
    mode: 'development',
    entry: './src/main.js',
    output: {
        filename: 'rad-chart-bundle.js',
        path: path.resolve(__dirname, 'dist'),
        publicPath: '/dist/'
    }
 
}