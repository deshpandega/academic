
# coding: utf-8

# In[209]:

import argparse
import os
import datetime as dt
import oauth2 as oauth
import json
import urllib.request as ur
import urllib.parse as par
from requests_oauthlib import OAuth1
import requests

API_KEY = "fIsG5ocnl8SVgbxD0aESYDkhz"
API_SECRET = "IKytIIG1oTbKwtdAuVUbJSzyXv4DnF8TTJkWHzgYPqG4hx1bQR"
ACCESS_TOKEN = "788621334687391744-T0qILt4jZgXUyOdmjs7lQWgKtBwXFTR"
ACCESS_TOKEN_SECRET = "zCH6Idk3DFzPUl7xBKP4cDVgNUOeu3vcBhTEp0DabKxKL"
url = 'https://api.twitter.com/1.1/account/verify_credentials.json'
auth = OAuth1(API_KEY, API_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET)
requests.get(url, auth=auth)

path = "C:\\Shamal\\NEU\\Python\\imdb\\imdbnew\\twitter\\FollowCount"
os.chdir(path)


# In[210]:

import csv
D = []
with open('links.csv', 'r') as f:
    for line in f.readlines():
        movieId,imdbId,tmdbId = line.strip().split(',')
        #print (len(imdbId))
        if(len(imdbId) == 4 and imdbId != 'imdbId'):
            imdbIdNew = 'tt000' + imdbId
        if(len(imdbId) == 5 and imdbId != 'imdbId'):
            imdbIdNew = 'tt00' + imdbId
        if(len(imdbId) == 3 and imdbId != 'imdbId'):
            imdbIdNew = 'tt0000' + imdbId
        if(len(imdbId) == 2 and imdbId != 'imdbId'):
            imdbIdNew = 'tt00000' + imdbId
        if(len(imdbId) == 1 and imdbId != 'imdbId'):
            imdbIdNew = 'tt000000' + imdbId
        if(len(imdbId) == 6 and imdbId != 'imdbId'):
            imdbIdNew = 'tt0' + imdbId
        #print (len(imdbId))
        if(len(imdbId) == 7 and imdbId != 'imdbId'):
            imdbIdNew = 'tt' + imdbId
        if(len(imdbId) == 7 and imdbId != 'imdbId'):
            D.append(imdbIdNew)


# In[ ]:

searchTermnew = "imdb_" + dt.datetime.now().strftime('%Y-%m-%d') + ".json"
            
def createMovieFile(r, path,usrID):
    file_loc_movie = os.path.join(path, searchTermnew)
    with open('file_loc_movie', 'a',newline='') as f:
        json.dump(r.json(), f)
        f.write(os.linesep)
        
for l in D[:10000]:
    url1 = "http://www.omdbapi.com/?i=" + str(l) + "&plot=short&r=json"
    r = requests.get(url1)
    createMovieFile(r, path,l)
    print (r.json())


# In[212]:

my_list =[]    
with open('file_loc_movie') as f:
    my_list = [json.loads(line) for line in f]
print (len(my_list))


# In[213]:

import csv
with open('output6.csv', 'w',newline='') as myfile:
    wr = csv.writer(myfile,delimiter=',', quoting=csv.QUOTE_ALL)
    wr.writerow(['Year','Runtime','imdbRating','Genre','imdbID',
                    'Metascore','Title','imdbVotes','Type','Language','Director','Awards','Actors','Plot',
                 'Country','Rated','Writer','Released'])
    for itm in my_list:
        wr.writerow([itm['Year'],itm['Runtime'], itm['imdbRating'],itm['Genre'],itm['imdbID'],
                    itm['Metascore'],itm['Title'], itm['imdbVotes'],itm['Type'],itm['Language'], itm['Director'],
                 itm['Awards'],itm['Actors'], itm['Plot'],itm['Country'], itm['Rated'],itm['Writer'],
                                                                       itm['Released']])


# In[231]:

S= []
with open('output6.csv','r') as csvinput:
    reader = csv.reader(csvinput)
    row = next(reader)
    for row in reader: 
        spaceTitleinput = row[6].replace(" ", "").lower()
        S.append(spaceTitleinput)
        print (spaceTitleinput)


# In[97]:

#S=[]
#for l in D:
#    for i in range(10):
#        url1 = "http://www.omdbapi.com/?i=" + str(l) + "&plot=short&r=json"
#        r = requests.get(url1)
#        keyTitle = r.json()['Title'].replace(" ", "")
#        S.append(keyTitle)
#    break


# In[233]:

import re
for i in S:
    #url1 = "https://api.twitter.com/1.1/friends/ids.json?screen_name=%23vineebhole"
    i = re.sub('[^A-Za-z0-9]+', '', i)
    url1 = "https://api.twitter.com/1.1/users/show.json?screen_name=" + i
    #print (i)
    r = requests.get(url1,auth=auth)
    if (r.json().get('screen_name')):
        #print (r.json())
        createjsonFile(r, path)


# In[120]:

#searchTermnew = "adhm" +"_" + dt.datetime.now().strftime('%Y-%m-%d') + ".json"
    
#def createFile(r, path):
#    file_loc = os.path.join(path, searchTermnew)
#    try:
#        fp = open(file_loc)
#    except IOError:
#        with open(file_loc, 'w') as f:
#            json.dump(r.json(), f)
#            f.write(os.linesep)


# In[230]:

searchTermnew = "imdb_" + dt.datetime.now().strftime('%Y-%m-%d') + ".json"
            
def createjsonFile(r, path):
    file_loc = os.path.join(path, searchTermnew)
    with open('file_loc', 'a',newline='') as f:
        json.dump(r.json(), f)
        f.write(os.linesep)


# In[234]:

my_listMovie =[]    
with open('file_loc') as f:
     my_listMovie = [json.loads(line) for line in f]
print (len(my_listMovie))


# In[235]:

for itm in my_listMovie:
    print (itm['screen_name'])


# In[199]:

for itm in my_listMovie:
    if(itm['screen_name'] != "heat"):
        print ("true")


# In[236]:

with open('output6.csv','r') as csvinput:
    with open('output6New.csv', 'w') as csvoutput:
        writer = csv.writer(csvoutput, lineterminator='\n')
        reader = csv.reader(csvinput)
        #print (reader)

        all = []
        row = next(reader)
        row.append('Latest Follower Count')
        all.append(row)
        #print (all)

        for row in reader:
            flag = 'False'
            for itm in my_listMovie:
                spaceTitleinput = row[6].replace(" ", "").lower()
                spacetitleListlower = itm.get('screen_name').lower()
                #print (spacetitleListlower)
                #print (spaceTitleinput)
                if(spacetitleListlower == spaceTitleinput):
                    flag = 'True'                    
                    row.append(itm.get('followers_count'))                    
                    all.append(row)
            if(flag == 'False'):
                row.append("0")                    
                all.append(row)
        writer.writerows(all)


# In[ ]:



