import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  componentDidMount() {
    this.loadPosts();
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => this.setState({ posts: data }))
      .catch(error => {
        this.setState({ error });
        console.error('Error fetching posts:', error);
      });
  }

  componentDidCatch(error, info) {
    alert('An error occurred: ' + error);
  }

  render() {
    const { posts } = this.state;
    return (
      <div>
        <h2>Blog Posts</h2>
        {posts.slice(0, 10).map(post => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </div>
    );
  }
}

export default Posts;
