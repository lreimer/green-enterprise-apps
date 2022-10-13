NAME = green-enterprise-app

default: build

image:
    @docker build -t $(NAME) .

build:
    @go build

clean:
	@rm -f $(NAME)
	