FROM golang:1.18-bullseye as build

WORKDIR /go/src/app
ADD . /go/src/app

RUN go get -d -v ./...
RUN go build -o /go/bin/green-enterprise-golang

FROM gcr.io/distroless/base-debian11

ENV PORT=8080

COPY --from=build /go/bin/green-enterprise-golang /

CMD ["/green-enterprise-golang"]
