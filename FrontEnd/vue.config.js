module.exports = {
  transpileDependencies: ["vuetify"],
  devServer: {
    overlay: false,
  },
  chainWebpack: (config) => {
    config.module.rules.delete("eslint");
  },
};
