FROM rust:1.64.0 as builder

WORKDIR /app
COPY . /app
RUN cargo build --release

FROM gcr.io/distroless/cc

ENV PORT=8080

COPY --from=builder /app/target/release/rust /green-enterprise-rust
ENTRYPOINT ["/green-enterprise-rust"]
