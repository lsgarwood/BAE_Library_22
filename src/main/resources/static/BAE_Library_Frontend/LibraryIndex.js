const baseURL = "http://localhost:8080"; 

    axios
        .get(`${baseURL}/books/getAll`)
        .then(res => { // handle response with callback
            console.log(res);
            console.log("DATA: ", res.data);
        }).catch(err => console.log(err)); // handle error

console.log("Library Initialising....");

const showOutput = document.querySelector("#showOutput");
const bookId = document.querySelector("#book-id");

const getAllBooks = () => {
   
    axios
        .get(`${baseURL}/books/getAll`)
        .then(res => {
            const books = res.data;
            showOutput.innerHTML = "";
            books.forEach(book => renderBook(book, showOutput));
        }).catch(err => console.log(err));
    }

const renderBook = (book) => {   
    const bookColumn = document.createElement('div');
    bookColumn.classList.add("col");
    
    const bookCard = document.createElement('div');
    bookCard.classList.add("card");
    bookColumn.appendChild(bookCard);
    
    const newBook = document.createElement('div');
    newBook.classList.add("card-body", "text-center");
    bookCard.appendChild(newBook);

    const bookBanner = document.createElement("span");
    bookBanner.classList.add("badge", "bg-danger")
    newBook.appendChild(bookBanner);

    // const bookImage = document.createElement("img");
    // bookImage.classList.add("card-img-top");
    // bookImage.src = `&{book.addImage}`;
    // newBook.appendChild(bookImage);
    
    const bookTitle = document.createElement("h5");
    bookTitle.innerText = book.title;
    bookTitle.classList.add("card-title");
    newBook.appendChild(bookTitle);
    
    const bookAuthor = document.createElement("p");
    bookAuthor.innerText = book.author;
    bookAuthor.classList.add("card-text");
    newBook.appendChild(bookAuthor);
    
    const bookGenre = document.createElement("p");
    bookGenre.innerText = book.genre;
    bookGenre.classList.add("card-text");
    newBook.appendChild(bookGenre);
    
    const bookCardId = document.createElement("p");
    bookCardId.innerText = book.id;
    bookCardId.classList.add("card-text");
    newBook.appendChild(bookCardId);

    const loanButton = document.createElement('loan-book');
    loanButton.innerText = "Loan";
    loanButton.classList.add("btn", "btn-secondary");
    loanButton.addEventListener('click', () => checkOut(book.id));
    newBook.appendChild(loanButton);

    const reviewButton = document.createElement('review-book');
    reviewButton.innerText = "Review";
    reviewButton.classList.add("btn", "btn-secondary");
    reviewButton.addEventListener('click', () => reviewBook(book.id));
    newBook.appendChild(reviewButton);
    
    showOutput.appendChild(bookColumn);
}

//review 
// const reviewBook = id => {

//     axios
//         .get(`${baseURL}/books/getReview`);
// //         .then
// }

// "/createBook"- donate book
document.querySelector("#donate-form").addEventListener("submit", (e) => {
    e.preventDefault();

    const form = e.target;

    const data = {
        title: form.title.value,
        author: form.author.value,
        genre: form.genre.value,
        id: form.id.value,
        available: false,
        url: form.image.value,
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
function getById() {
    
    axios
        .get(`${baseURL}/books/getById/id`)
        .then(res => getAllOutput(res))
        .catch(err => alert(err));
}

// "/getByAvailable/{available}" - serach by available
// "/checkIn/{id}" - by id

document.querySelector("#return-button").addEventListener("click", (e) => {
    e.preventDefault();

    const id = document.querySelector("#return-input").value;

    const data = {
        title: "body bug fix"
    }

    axios
        .put(`${baseURL}/books/checkIn/${id}`, data)
        .then(res => {
            console.log(res);
            getAllBooks();
        }).catch(err => console.log(err));
    });

// "/checkOut/{id}" - update
// const checkOut = id => {

//     axios
//         .put(`${baseURL}/books/checkOut/id`)
//         .then(res => {
            
//         })

// }
// "/deleteBook/{id}" - delete
document.querySelector("#remove-button").addEventListener("click", (e) => {
    e.preventDefault();

    const id = document.querySelector("#remove-input").value;

    axios
        .delete(`${baseURL}/books/deleteBook/${id}`)
        .then(res => {
            console.log(res);
            getAllBooks();
            id.delete();
        }).catch(err => console.log(err));
    });
