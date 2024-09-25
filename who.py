from datetime import datetime, timedelta
import requests

def get_commits(author, branch='main'):
    yesterday = (datetime.now() - timedelta(days=1)).isoformat()
    url = f'https://api.github.com/repos/seohye-ki/morning-in-algo/commits'
    params = {'sha': branch, 'author': author, 'since' : yesterday}
    
    response = requests.get(url, params=params)
    
    if response.status_code == 200:
        commits = response.json()
        if commits:
            print(author,"통과")
        else :
            print(author,"반성하세요")
    else:
        print(f"Error: {response.status_code} - {response.text}")

def main():
    authors = {'seohye-ki','ljh0401','pasongvan', 'isemae', 'criti0728'}
    for author in authors:
        get_commits(author)

main()