from datetime import datetime, timedelta
import requests
class Who:

    def __init__(self):

        authors = ['seohye-ki','ljh0401','pasongvan', 'isemae', 'criti0728']

        for author in authors:
            self.get_commits(author)

    def get_commits(self, author, branch='main'):
        yesterday = (datetime.now() - timedelta(days=1)).isoformat()
        url = 'https://api.github.com/repos/seohye-ki/morning-in-algo/commits'
        params = {'sha': branch, 'author': author, 'since' : yesterday}
        print(url, params)

        response = requests.get(url, params=params)
        
        if response.status_code == 200:
            commits = response.json()
            if commits:
                print(author,"통과")
            else :
                print(author,"반성하세요")
        else:
            print(f"Error: {response.status_code} - {response.text}")


Who()