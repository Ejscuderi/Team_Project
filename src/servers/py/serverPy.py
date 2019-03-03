from bottle import route, run, template
import bottle


@route('/hello/<name>', method="GET")


def index(name):
    name = "TA. "
    return template("<b>Hello {{name}} This is my server demo</b>", name=name)


@route('/requestStuff.py')
def map():
    return bottle.static_file("requestStuff.py", root="")


run(host='localhost', port=8080)
