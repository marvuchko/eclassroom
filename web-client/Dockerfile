FROM node:12.13.1-alpine AS build

WORKDIR /usr/src/app
COPY ./package.json ./
RUN npm install
COPY . .
RUN npm run build:prod

FROM nginx:1.17.1-alpine
COPY --from=build /usr/src/app/dist/eclassroom /usr/share/nginx/html
