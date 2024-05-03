document.addEventListener('DOMContentLoaded', function() {
    fetchBooks();
});

function fetchBooks() {
    fetch('http://localhost:8080/api/books')
        .then(response => response.json())
        .then(books => {
            const list = document.getElementById('books');
            list.innerHTML = '';
            books.forEach(book => {
                const li = document.createElement('li');
                li.textContent = book.title + " by " + book.author;
                list.appendChild(li);
            });
        })
        .catch(error => console.error('Error fetching books:', error));
}

function addBook(event) {
    event.preventDefault();

    const title = document.getElementById('title').value;
    const author = document.getElementById('author').value;

    const data = {
        title: title,
        author: author
    };

    fetch('http://localhost:8080/api/books', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then(response => {
        if (response.ok) {
            fetchBooks();
        } else {
            alert('Failed to add book');
        }
    })
    .catch(error => {
        console.error('Error adding book:', error);
    })

    document.getElementById('title').value = '';
    document.getElementById('author').value = '';
}