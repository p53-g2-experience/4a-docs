from django.urls import path
from dictionaryApp.views import word

urlpatterns = [
    path('list/', word.WordListAllView.as_view()),
#    path('list/<int:pk>', word.WordDetailsView.as_view()),
    path('create/', word.WordCreateView.as_view()),
    path('update/<int:pk>', word.WordUpdateView.as_view()),
    path('delete/<int:pk>', word.WordDeleteView.as_view()),
]