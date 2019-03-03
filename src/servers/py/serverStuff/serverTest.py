import bottle
import json
import src.servers.py.serverStuff.writeFile


a = src.servers.py.serverStuff.writeFile


@bottle.route('/')
def index():
    return bottle.static_file("GUI.html", root="")

@bottle.route('/user.js')
def static():
    return bottle.static_file("user.js", root="")


@bottle.route('/user')
def get_users():
    # a.add_user("hi")
    content = bottle.request.body.read().decode()
    content = json.loads(content)
    a.add_user(content['user'])
    return json.dumps(a.get_user())


bottle.run(host="localhost", port=8080, debug=True)