#!/usr/bin/python2.7
# -*- coding: utf-8 -*-

import json
import urllib2


def read_json_file(path):
    brandsFile = open(path)
    content = ''
    for line in brandsFile:
        content = content + line
    jsonContent = json.loads(content)
    return jsonContent


def load_brands():
    return read_json_file('db/brands.json')


def load_phones():
    return read_json_file('db/phones.json')


def inject(type, objects):
    print 'creating %s elements' % len(objects)
    for item in objects:
        req = urllib2.Request('http://localhost:9000/%s/' % type)
        req.add_header('Content-Type', 'application/json')
        try:
            payload = json.dumps(item)
            response = urllib2.urlopen(req, payload)
            print "creation of %s '%s' successful." % (type, item[u'name'])
        except Exception, e:
            print "creation of %s '%s' failed (%s)." % (type, item[u'name'], e)


if __name__ == "__main__":
    brands = load_brands()
    phones = load_phones()
    inject('brand', brands)
    inject('phone', phones)

