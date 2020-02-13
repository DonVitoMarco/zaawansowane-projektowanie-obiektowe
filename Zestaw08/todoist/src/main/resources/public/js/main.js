getTodos(0);

function getTodos(pageNumber) {
    fetch(`http://localhost:8080/todoist?page=${pageNumber}&size=5`)
        .then(response => {
            return response.json()
        })
        .then(data => {
            document.querySelectorAll(".todo-item").forEach(e => e.parentNode.removeChild(e));
            document.querySelectorAll(".page-item").forEach(e => e.parentNode.removeChild(e));
            data.content.forEach(t => printTodo(t));

            if (data.totalPages > 1) {
                for (const x of Array(data.totalPages).keys()) {
                    printPagination(x + 1);
                }
            }
        });
}

function printTodo(todo) {
    const list = document.querySelector('.js-todo-list');
    list.insertAdjacentHTML('beforeend', `
      <li class="todo-item" data-key="${todo.id}">
        <button class="svg-todo js-done-todo">
          <svg><use href="#check-icon"></use></svg>
        </button>
        <span class="todo-content">${todo.content}</span>
        <span class="todo-status">${todo.status}</span>
        <button class="svg-todo js-undone-todo">
          <svg><use href="#delete-icon"></use></svg>
        </button>
      </li>
    `);
}

function printPagination(pageNumber) {
    const list = document.querySelector('.js-page-list');
    list.insertAdjacentHTML('beforeend', `
      <li class="page-item" data-key="${pageNumber}">
        <label for="${pageNumber}"></label>
        <span>${pageNumber}</span>
      </li>
    `);
}


function addTodo(todo, firstName, lastName, email) {
    const request = {
        firstName: firstName,
        lastName: lastName,
        email: email,
        content: todo
    };

    fetch("http://localhost:8080/todoist", {
        method: 'POST',
        body: JSON.stringify(request),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        getTodos(0);
    });
}

function toggleDone(key) {
    fetch(`http://localhost:8080/todoist/${key}`, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        console.log(response);
        getTodos(0);
    });
}

function toggleUndone(key) {
    fetch(`http://localhost:8080/todoist/${key}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        getTodos(0);
    });
}

const form = document.querySelector('.js-form');
form.addEventListener('submit', event => {
    event.preventDefault();
    const todo = document.querySelector('.js-todo-input').value.trim();
    const firstName = document.querySelector('.js-first-name-input').value.trim();
    const lastName = document.querySelector('.js-last-name-input').value.trim();
    const email = document.querySelector('.js-email-input').value.trim();

    if (todo !== '' && firstName !== '' && lastName !== '' && email !== '') {
        addTodo(todo, firstName, lastName, email);
        clearForm();
    }
});

function clearForm() {
    document.querySelector('.js-todo-input').value = '';
    document.querySelector('.js-first-name-input').value = '';
    document.querySelector('.js-last-name-input').value = '';
    document.querySelector('.js-email-input').value = '';
}

const list = document.querySelector('.js-todo-list');
list.addEventListener('click', event => {
    if (event.target.classList.contains('js-done-todo')) {
        const itemKey = event.target.parentElement.dataset.key;
        toggleDone(itemKey);
    }

    if (event.target.classList.contains('js-undone-todo')) {
        const itemKey = event.target.parentElement.dataset.key;
        toggleUndone(itemKey);
    }
});

const page = document.querySelector('.js-page-list');
page.addEventListener('click', event => {
    const itemKey = event.target.parentElement.dataset.key;
    getTodos(itemKey - 1)
});

