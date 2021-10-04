## Rick and Morty Mobile App

### Описание приложения.
Single activity Приложение-терминал по мульт-вселенной "Rick&Morty" в котором пользователь может просмотреть список персонажей, эпизодов и локаций данного мульт-сериала.

### Стек технологий
1. Язык программирования Java.
2. Retrofit.
3. RxJava.
4. DI Dagger
5. JUnit, Mockito, Truth
6. Picasso
7. Fragments
8. ViewModel
9. SharedPreference


### Архитектура приложения.
Для данного приложения использовался архитектурный паттерн MVVM(Model View ViewModel) совместно с Clean Architecture,а так же принцип разработки SOLID. 
1. Model - слой, отвечающий за бизнес-логику приложения.
2. View - слой, отвечающий за весь ui приложения.
3. ViewModel - слой, являющийся посредником между View и Model.

### Структура
Представляет из себя 4 слоя:
1. data-пакет (все что связано с бизнес-логикой приложения, в основном это получение информации из сервера и последующая конвертация).
2. di-пакет (инъекция зависимотей нашего приложения).
3. domain-пакет (use case приложения, хранит в себе интеракторы, которые просто получают отконвертированную информацию с репозитория).
4. presentation-пакет (хранит в себе работу с UI приложения, а именно адаптеры, вьюхолдеры, активити, фрагменты и view-модельки).
5. models-пакет (хранит в себе классы-сущности приложения).
6. utils (утилитные классы, для вторичной работы).

### Покрытие тестами
Тестами покрыто 28% приложения (включая всё).
