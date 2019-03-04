import bottle
import json
# import urllib.request
import src.servers.py.serverStuff.writeFile


a = src.servers.py.serverStuff.writeFile


@bottle.route('/')
def index():
    return bottle.static_file("GUI.html", root="")


@bottle.route('/user.js')
def static():
    return bottle.static_file("user.js", root="")


@bottle.route('/join')
def get_users():
    # a.add_user("hi")
    content = bottle.request.body.read().decode()
    contents = json.loads(content)
    a.add_user(contents['user'])
    return json.dumps(a.get_user())


    # url = "http://localhost:8080/"
    # request = urllib.request.urlopen(url).read().decode()
    # answer = json.loads(request)
    # a.add_user(answer['users'])
    # return json.dumps(a.get_user())


bottle.run(host="localhost", port=8080, debug=True)
