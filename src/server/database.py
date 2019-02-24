# import sqlite3
#
# conn = sqlite3.connect('project.db')
# cur = conn.cursor()
#
# def createdb(username):
#     cur.execute('CREATE TABLE IF NOT EXISTS interactions (username)')
#     cur.execute('INSERT INTO interactions VALUES (?)', (username))
#
#     conn.commit()
#     conn.close()
#
