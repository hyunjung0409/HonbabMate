import axios from "axios";

export default {
  axios: axios.create({
    baseURL: "https://i6c206.p.ssafy.io/api",
    headers: {
      "Content-Type": "application/json",
    },
  }),
};
