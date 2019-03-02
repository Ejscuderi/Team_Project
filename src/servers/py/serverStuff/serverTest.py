import bottle
import json
import src.servers.py.serverStuff.writeFile

a = src.servers.py.serverStuff.writeFile


@bottle.route('/')
def index():
    return bottle.static_file("index.html", root="")

@bottle.route('/chat.js')
def static():
    return bottle.static_file("chat.js", root="")

@bottle.route('/user')
def get_users():
    return json.dumps(a.get_user())

@bottle.route('/send')
def do_users():
    content = bottle.request.body.read().decode()
    content = json.loads(content)
    a.add_user(content['user'])
    return json.dumps(a.get_user())

bottle.run(host="localhost", port=8080, debug=True)