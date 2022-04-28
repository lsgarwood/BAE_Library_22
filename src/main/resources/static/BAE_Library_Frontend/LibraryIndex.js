const baseURL = "http://localhost:8080"; 

    axios
        .get(`${baseURL}/books/getAll`)
        .then(res => { // handle response with callback
            console.log(res);
            console.log("DATA: ", res.data);
        }).catch(err => console.log(err)); // handle error

console.log("Library Initialising....");

const showOutput = document.querySelector("#getAllOutput");
const bookId = document.querySelector("#book-id");

const getAllBooks = () => {
   
    axios
        .get(`${baseURL}/books/getAll`)
        .then(res => {
            const books = res.data;
            getAllOutput.innerHTML = "";
            books.forEach(book => renderBook(book, swhowOutput));
        }).catch(err => console.log(err));
    }

const renderBook = (book) => {   
    const bookColumn = document.createElement('div');
    bookColumn.classList.add("col");
    
    const bookCard = document.createElement('div');
    bookCard.classList.add("card");
    bookColumn.appendChild(bookCard);
    
    const bookBody = document.createElement('div');
    bookBody.classList.add("card-body");

    const bookCardBanner = document.createElement("span");
    bookCardBanner.classList.add("card-banner ")
    if (book.isAvailable) {
        bookCardBanner.innerText = "Available" ;
        bookCardBanner.classList.add("btn btn-success")
    } else {
        bookCardBanner.innerTest = "On-Loan";
        bookCardBanner.classList.add("btn btn-danger")
    }
    bookCardBanner.appendChild(bookCardBanner);

    // const bookImage = document.createElement("img");
    // bookImage.classList.add("card-img-top");
    // bookImage.src = `&{book.addImage}`;
    // newBook.appendChild(bookCardImage);
    
    const bookTitle = document.createElement("h5");
    bookTitle.innerText = book.title;
    bookTitle.classList.add("card-title");
    newBook.appendChild(bookTitle);
    
    const bookAuthor = document.createElement("p");
    bookAuthor.innerText = book.author;
    bookAuthor.classList.add("card-author");
    newBook.appendChild(bookAuthor);
    
    const bookGenre = document.createElement("p");
    bookGenre.innerText = book.author;
    bookGenre.classList.add("card-genre");
    newBook.appendChild(bookGenre);
    
    const bookCardId = document.createElement("p");
    bookCardId.innerText = book.id;
    bookCardId.classList.add("card-id");
    newBook.appendChild(bookCardId);
    
    const loanButton = document.createElement('loan-book');
    loanButton.innerText = "Loan";
    loanButton.classList.add("btn", "btn-primary");
    loanButton.addEventListener('click', () => checkOut(book.id));
    newBook.appendChild(loanButton);
    bookCard.appendChild(newBook);

    const reviewButton = document.createElement('review-book');
    reviewButton.innerText = "Review";
    reviewButton.classList.add("btn", "btn-secondary");
    reviewButton.addEventListener('click', () => reviewBook(book.id));
    newBook.appendChild(reviewButton);
    bookCard.appendChild(newBook);
    
    getAllBooks.appendChild(bookColumn);
}

const reviewBook = id => {

}

// "/createBook"- donate book
document.querySelector("input# > form").addEventListener('add-button', (e) => {
    e.preventDefault();

    const form = e.target;

    const data = {
        title: form.title.value,
        author: form.author.value,
        genre: form.genre.value,
        id: form.id.value,
        url: form.url.value,
        review: form.review.value
    }

    console.log("DATA: ", data);

    axios
        .post(`${baseURL}/books/createBook`, data)
        .then((res) => {
        console.log(res);
        getAllBooks();

        form.reset(); //resets form
        form.title.focus(); // selects the name input
    }).catch(err => console.log(err));
});

getAllBooks();

// "/getByTitle/{title}" - search by title
function searchResultsByTitle() {

    axios
        .get(`${baseURL}/books/getByTitle/title`)
        .then(res => showSearchResults(res))
        .catch(err => alert(err));
}

// "/getByAuthor/{author}" -search by author
function searchResultsByAuthor() {

    axios
        .get(`${baseURL}/books/getByAuthor/author`)
        .then(res => showSearchResults(res))
        .catch(err => alert(err));
}

// "/getByGenre/{genre}" search by genre
function searchResultsByGenre() {

    axios
        .get(`${baseURL}/books/getByGenre/genre`)
        .then(res => getAllOutput(res))
        .catch(err => alert(err));
}

// "/getById/{id}" search by id
function searchResultsById() {
    
    axios
        .get(`${baseURL}/books/getById/id`)
        .then(res => getAllOutput(res))
        .catch(err => alert(err));
}

// "/getByAvailable/{available}" - serach by available
// "/checkIn/{id}" - by id

// "/checkOut/{id}" - update
const checkOut = id => {

    axios
        .put(`${baseURL}/books/checkOut/id`)
        .then(res => {
            
        })

}
// "/deleteBook/{id}" - delete