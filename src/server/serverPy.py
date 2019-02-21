from bottle import route, run, template

@route('/hello/<name><text>')
def index(name, text):
    name="TA. "
    text="This is my server demo for the project"
    return template('<b>Hello {{name}}{{text}}</b>!', name=name, text=text)

run(host='localhost', port=8080)

# http://localhost:8080/hello/world

